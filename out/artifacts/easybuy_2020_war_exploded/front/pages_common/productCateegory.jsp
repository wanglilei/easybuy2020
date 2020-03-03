<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/3
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="menu_bg">
    <div class="menu">
        <!--Begin 商品分类详情 Begin-->
        <div class="nav">
            <div class="nav_t">全部商品分类</div>
            <div class="leftNav none">
                <ul>
                    <c:forEach items="${categoryLists}" var="pc">
                        <li><div class="fj"><span class="n_img"><span></span><img src="${ctx}/images/nav1.png" /></span><span class="fl">${pc.productCategory.name}</span>
                        </div><div class="zj"><div class="zj_l"><c:forEach items="${pc.productCategoryVoList}" var="pc2">
                            <div class="zj_l_c">
                                <h2><a href="${ctx}/product?action=queryProducts&categoryId=${pc2.productCategory.id}">${pc2.productCategory.name}</a></h2>
                                <c:forEach items="${pc2.productCategoryVoList}" var="pc3">
                                    <a href="${ctx}/product?action=queryProducts&categoryId=${pc3.productCategory.id}">${pc3.productCategory.name}</a>|
                                </c:forEach>
                            </div>
                        </c:forEach>
                        </div>
                            <div class="zj_r">
                                <a href="#"><img src="${ctx}/images/n_img1.jpg" width="236" height="200" /></a>
                                <a href="#"><img src="${ctx}/images/n_img2.jpg" width="236" height="200" /></a>
                            </div>
                        </div>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <!--End 商品分类详情 End-->
        <ul class="menu_r">
            <li><a href="${ctx}/home?action=index">首页</a></li>
            <c:forEach var="category" items="${categoryLists}">
                <li>
                    <a href="${ctx}/product?action=queryProducts&categoryId=${category.productCategory.id}">${category.productCategory.name}</a>|
                        <%--                                    <a href="Index.html">${category.productCategory.name}</a>--%>
                </li>
            </c:forEach>
            <%--            <li><a href="Food.html">美食</a></li>--%>
            <%--            <li><a href="Fresh.html">生鲜</a></li>--%>
            <%--            <li><a href="HomeDecoration.html">家居</a></li>--%>
            <%--            <li><a href="SuitDress.html">女装</a></li>--%>
            <%--            <li><a href="MakeUp.html">美妆</a></li>--%>
            <%--            <li><a href="Digital.html">数码</a></li>--%>
            <%--            <li><a href="GroupBuying.html">团购</a></li>--%>
        </ul>
        <div class="m_ad">中秋送好礼！</div>
    </div>
</div>
