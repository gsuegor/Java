<#import "parts/common.ftl" as c>

<@c.page "Certification system">
    <div class="row">
        <#list users as user>
            <div class="col-4">
                <a href="/profile?userId=${user.userId}">
                    <div class="card my-4" style="width: 18rem;">
                        <div class="card-body">
                            <h5 class="card-title ml-5 pl-5">${user.username}</h5>
                        </div>
                        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQN8TWILq5xtPlLCv0TT6XWeCy78tu0PRQdET_T3-lMUIGSdtowGg&s" class="card-img-top" alt="...">
                    </div>
                </a>
            </div>
        </#list>
    </div>
</@c.page>