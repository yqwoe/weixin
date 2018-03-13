<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/commons/taglibs.html"%>
<div class="am-cf am-padding">
    <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">首页</strong> / <small>用户管理</small></div>
</div>
<hr>
<div class="am-btn-group">
    <a href="/users/new" class="am-btn am-btn-secondary am-btn-sm"> 添加用户 </a>
</div>
<br/>

<table class="am-table am-table-bd am-table-striped admin-content-table">
    <thead>
    <tr>
        <th>ID</th><th>用户名</th><th>最后成交任务</th><th>成交订单</th><th>管理</th>
    </tr>
    </thead>
    <tbody>
    <tr><td>1</td><td>John Clark</td><td><a href="#">Business management</a></td> <td><span class="am-badge am-badge-success">+20</span></td>
        <td>
            <div class="am-dropdown" data-am-dropdown="">
                <button class="am-btn am-btn-default am-btn-xs am-dropdown-toggle" data-am-dropdown-toggle=""><span class="am-icon-cog"></span> <span class="am-icon-caret-down"></span></button>
                <ul class="am-dropdown-content">
                    <li><a href="#">1. 编辑</a></li>
                    <li><a href="#">2. 下载</a></li>
                    <li><a href="#">3. 删除</a></li>
                </ul>
            </div>
        </td>
    </tr>

    </tbody>
</table>