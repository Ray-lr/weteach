<#macro modal class target content>
<button type="button" class="btn ${class}" data-toggle="modal" data-target="#${target}">
${content}
</button>
</#macro>