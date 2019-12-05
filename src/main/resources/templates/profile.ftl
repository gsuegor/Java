<#import "parts/common.ftl" as c>

<@c.page "Users profile">
    <div class="row">
        <h4 class="mt-4">${user.username}'s certificates</h4>
    </div>
    <div class="row">
        <#list certificates as item>
            <div class="col-4">
                <div class="card mt-4" style="width: 18rem;">
                    <div class="card-header">
                        ${item.title}
                    </div>
                    <div class="card-body">
                        <p class="card-text">${item.description}</p>
                    </div>
                    <div class="card-footer text-muted">
                        ${item.issuedBy}
                    </div>
                </div>
            </div>
        </#list>
    </div>
</@c.page>