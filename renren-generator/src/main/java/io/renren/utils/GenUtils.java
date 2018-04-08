package io.renren.utils;

import io.renren.entity.ColumnEntity;
import io.renren.entity.TableEntity;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 代码生成器   工具类
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年12月19日 下午11:40:24
 */
public class GenUtils {

    private static List<String> getTemplates() {
        return new ArrayList<String>() {{
            add("template/Controller.java.vm");
            add("template/Entity.java.vm");
            add("template/Example.java.vm");
            add("template/Mapper.java.vm");
            add("template/Mapper.xml.vm");
            add("template/Service.java.vm");
            add("template/ServiceImpl.java.vm");
            add("template/VO.java.vm");
        }};
    }

    private static List<String> getLegendTemplates() {
        return new ArrayList<String>() {{
            add("legendTemplate/Controller.java.vm");
            add("legendTemplate/Entity.java.vm");
            add("legendTemplate/Example.java.vm");
            add("legendTemplate/Mapper.java.vm");
            add("legendTemplate/Mapper.xml.vm");
            add("legendTemplate/Service.java.vm");
            add("legendTemplate/ServiceImpl.java.vm");
            add("legendTemplate/VO.java.vm");
        }};
    }

    /**
     * 生成代码
     */
    public static void generatorCode(Map<String, String> table,
                                     List<Map<String, String>> columns, ZipOutputStream zip) {
        //配置信息
        Configuration config = getConfig();
        boolean hasBigDecimal = false;
        boolean hasDate = false;
        //表信息
        TableEntity tableEntity = new TableEntity();
        tableEntity.setTableName(table.get("tableName"));
        tableEntity.setComments(table.get("tableComment"));
        //表名转换成Java类名
        String className = tableToJava(tableEntity.getTableName(), config.getString("tablePrefix"));
        tableEntity.setClassName(className);
        tableEntity.setClassname(StringUtils.uncapitalize(className));

        //列信息
        List<ColumnEntity> columnList = new ArrayList<>();
        for (Map<String, String> column : columns) {
            ColumnEntity columnEntity = new ColumnEntity();
            columnEntity.setColumnName(column.get("columnName"));
            columnEntity.setDataType(column.get("dataType"));
            columnEntity.setComments(column.get("columnComment"));
            columnEntity.setExtra(column.get("extra"));

            //列名转换成Java属性名
            String attrName = columnToJava(columnEntity.getColumnName());
            columnEntity.setAttrName(attrName);
            columnEntity.setAttrname(StringUtils.uncapitalize(attrName));
            columnEntity.setAttrNAME(columnEntity.getColumnName().toUpperCase());

            //列的数据类型，转换成Java类型
            String attrType = config.getString(columnEntity.getDataType(), "unknowType");
            columnEntity.setAttrType(attrType);
            String jdbcType = config.getString(columnEntity.getAttrType(), "unknowType");
            columnEntity.setJdbcType(jdbcType);
            if (!hasBigDecimal && "BigDecimal".equals(attrType)) {
                hasBigDecimal = true;
            }
            if (!hasDate && ("Date".equals(attrType) || "DateTime".equals(attrType))) {
                hasDate = true;
            }
            //是否主键
            if ("PRI".equalsIgnoreCase(column.get("columnKey")) && tableEntity.getPk() == null) {
                tableEntity.setPk(columnEntity);
            }

            if (columns.size() - 1 == columnList.size()) {
                columnEntity.setLast(true);
            }
            columnList.add(columnEntity);
        }
        tableEntity.setColumns(columnList);

        //没主键，则第一个字段为主键
        if (tableEntity.getPk() == null) {
            tableEntity.setPk(tableEntity.getColumns().get(0));
        }

        //设置velocity资源加载器
        Properties prop = new Properties();
        prop.put("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        Velocity.init(prop);
        String mainPath = config.getString("mainPath");
        mainPath = StringUtils.isBlank(mainPath) ? "io.renren" : mainPath;
        //封装模板数据
        Map<String, Object> map = new HashMap<>();
        map.put("tableName", tableEntity.getTableName());
        map.put("comments", tableEntity.getComments());
        map.put("pk", tableEntity.getPk());
        map.put("className", tableEntity.getClassName());
        map.put("classname", tableEntity.getClassname());
        map.put("pathName", tableEntity.getClassname().toLowerCase());
        map.put("columns", tableEntity.getColumns());
        map.put("hasBigDecimal", hasBigDecimal);
        map.put("hasDate", hasDate);
        map.put("mainPath", mainPath);

        map.put("package", config.getString("package"));
        map.put("moduleName", tableEntity.getTableName().split(Constant.SEPERATOR_UNDERLINE)[0]);
        config.setProperty("moduleName", map.get("moduleName"));
        map.put("module", StringUtils.uncapitalize(tableToJava(tableEntity.getTableName(), map.get("moduleName").toString())));
        map.put("author", config.getString("author"));
        map.put("email", config.getString("email"));
        map.put("datetime", DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));
        VelocityContext context = new VelocityContext(map);

        //获取模板列表
        List<String> templates = getLegendTemplates();
        for (String template : templates) {
            //渲染模板
            StringWriter sw = new StringWriter();
            Template tpl = Velocity.getTemplate(template, "UTF-8");
            tpl.merge(context, sw);
            try {
                //添加到zip
                zip.putNextEntry(new ZipEntry(getLegendFileName(template, tableEntity.getClassName(), config
                        .getString("package"), config.getString("moduleName"))));
                IOUtils.write(sw.toString(), zip, "UTF-8");
                IOUtils.closeQuietly(sw);
                zip.closeEntry();
            } catch (IOException e) {
                throw new RRException("渲染模板失败，表名：" + tableEntity.getTableName(), e);
            }
        }
    }


    /**
     * 列名转换成Java属性名
     */
    private static String columnToJava(String columnName) {
        return WordUtils.capitalizeFully(columnName, new char[]{'_'}).replace("_", "");
    }

    /**
     * 表名转换成Java类名
     */
    private static String tableToJava(String tableName, String tablePrefix) {
        if (StringUtils.isNotBlank(tablePrefix)) {
            tableName = tableName.replace(tablePrefix, "");
        }
        return columnToJava(tableName);
    }

    /**
     * 获取配置信息
     */
    public static Configuration getConfig() {
        try {
            return new PropertiesConfiguration("generator.properties");
        } catch (ConfigurationException e) {
            throw new RRException("获取配置文件失败，", e);
        }
    }

    /**
     * 获取legend下的文件名
     */
    private static String getLegendFileName(String template, String className, String packageName, String moduleName) {
        String packagePath = "main" + File.separator + "java" + File.separator;
        if (StringUtils.isNotBlank(packageName)) {
            packagePath += packageName.replace(".", File.separator) + File.separator;
        }
        if ("legendTemplate/Controller.java.vm".equals(template)) {
            return packagePath + "web" + File.separator + "controller" + File.separator + moduleName + File.separator +
                    className + "Controller.java";
        }
        if ("legendTemplate/Entity.java.vm".equals(template)) {
            return packagePath + "model" + File.separator + "pojo" + File.separator + "entity" + File.separator
                    + moduleName + File.separator + className + ".java";
        }
        if ("legendTemplate/Example.java.vm".equals(template)) {
            return packagePath + "model" + File.separator + "pojo" + File.separator + "entity" + File.separator
                    + moduleName + File.separator + className + "Example.java";
        }
        if ("legendTemplate/Mapper.java.vm".equals(template)) {
            return packagePath + "dao" + File.separator + "mapper" + File.separator + moduleName + File.separator +
                    className + "Mapper.java";
        }
        if ("legendTemplate/Mapper.xml.vm".equals(template)) {
            return packagePath + "dao" + File.separator + "xml" + File.separator + moduleName + File.separator + className +
                    "Mapper.xml";
        }
        if ("legendTemplate/Service.java.vm".equals(template)) {
            return packagePath + "service" + File.separator + moduleName + File.separator + className + "Service.java";
        }
        if ("legendTemplate/ServiceImpl.java.vm".equals(template)) {
            return packagePath + "service" + File.separator + moduleName + File.separator + "impl" + File.separator + className +
                    "ServiceImpl.java";
        }
        if ("legendTemplate/VO.java.vm".equals(template)) {
            return packagePath + "model" + File.separator + "pojo" + File.separator + "vo" + File.separator +
                    moduleName + File.separator + className + "VO.java";
        }
        return null;
    }

    /**
     * 获取文件名
     */
    private static String getFileName(String template, String className, String packageName, String moduleName) {
        String packagePath = "main" + File.separator + "java" + File.separator;
        if (StringUtils.isNotBlank(packageName)) {
            packagePath += packageName.replace(".", File.separator) + File.separator + moduleName + File.separator;
        }
        if ("template/Controller.java.vm".equals(template)) {
            return packagePath + "web" + File.separator + "controller" + File.separator + className + "Controller.java";
        }
        if ("template/Entity.java.vm".equals(template)) {
            return packagePath + "model" + File.separator + "pojo" + File.separator + "entity" + File.separator + className + ".java";
        }
        if ("template/Example.java.vm".equals(template)) {
            return packagePath + "model" + File.separator + "pojo" + File.separator + "entity" + File.separator + className + "Example.java";
        }
        if ("template/Mapper.java.vm".equals(template)) {
            return packagePath + "dao" + File.separator + "mapper" + File.separator + className +
                    "Mapper.java";
        }
        if ("template/Mapper.xml.vm".equals(template)) {
            return packagePath + "dao" + File.separator + "mapper" + File.separator + "xml" + File.separator + className +
                    "Mapper.xml";
        }
        if ("template/Service.java.vm".equals(template)) {
            return packagePath + "service" + File.separator + className + "Service.java";
        }
        if ("template/ServiceImpl.java.vm".equals(template)) {
            return packagePath + "service" + File.separator + "impl" + File.separator + className + "ServiceImpl.java";
        }
        if ("template/VO.java.vm".equals(template)) {
            return packagePath + "model" + File.separator + "pojo" + File.separator + "vo" + File.separator + className + "VO.java";
        }
        return null;
    }
}
