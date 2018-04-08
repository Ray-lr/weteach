<#macro top title="'提示'" content="" id="modal-top" class="" btnText="'Click'" cancelText="'取消'" determineText="'确定'"
btnFunction=""
cancelFunction=""
determineFunction=""
close=false>
<#-- btn -->
<button type="button" class="btn ${class}" data-toggle="modal" data-target="#${id}" v-text="${btnText}"
        @click="${btnFunction}">
</button>
<#-- Modal -->
<div class="modal fade" id="${id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel" v-text="${title}"></h5>
                <#if close>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </#if>
            </div>
            <div class="modal-body">
            ${content}
            </div>
            <div class="modal-footer">
                <#if cancelText??>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal"
                            v-text="${cancelText}" @click="${cancelFunction}">Cancel
                    </button>
                </#if>
                <#if determineText??>
                    <button type="button" class="btn btn-primary" data-dismiss="modal"
                            v-text="${determineText}" @click="${determineFunction}">Determine
                    </button>
                </#if>
            </div>
        </div>
    </div>
</div>
</#macro>

<#macro vertical title="'提示'" content="" id="modal-vertical" class="" btnText="'Click'" cancelText="'取消'" determineText="'确定'"
btnFunction=""
cancelFunction=""
determineFunction=""
close=false>
<#-- btn -->
<button type="button" class="btn ${class}" data-toggle="modal" data-target="#${id}" v-text="${btnText}"
        @click="${btnFunction}">
</button>
<#-- Modal -->
<div class="modal fade" id="${id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel" v-text="${title}"></h5>
                <#if close>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </#if>
            </div>
            <div class="modal-body">
            ${content}
            </div>
            <div class="modal-footer">
                <#if cancelText??>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal"
                            v-text="${cancelText}" @click="${cancelFunction}">Cancel
                    </button>
                </#if>
                <#if determineText??>
                    <button type="button" class="btn btn-primary" data-dismiss="modal"
                            v-text="${determineText}" @click="${determineFunction}">Determine
                    </button>
                </#if>
            </div>
        </div>
    </div>
</div>
</#macro>

<#macro long title="'提示'" content="" id="modal-long" class="" btnText="Click" cancelText="'取消'" determineText="'确定'"
btnFunction=""
cancelFunction=""
determineFunction=""
close=false>
<#-- btn -->
<button type="button" class="btn ${class}" data-toggle="modal" data-target="#${id}" v-text="${btnText}"
        @click="${btnFunction}">
</button>
<#-- Modal -->
<div class="modal fade" id="${id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle" v-text="${title}"></h5>
                <#if close>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </#if>
            </div>
            <div class="modal-body">
            ${content}
            </div>
            <div class="modal-footer">
                <#if cancelText??>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal"
                            v-text="${cancelText}" @click="${cancelFunction}">Cancel
                    </button>
                </#if>
                <#if determineText??>
                    <button type="button" class="btn btn-primary" data-dismiss="modal"
                            v-text="${determineText}" @click="${determineFunction}">Determine
                    </button>
                </#if>
            </div>
        </div>
    </div>
</div>
</#macro>