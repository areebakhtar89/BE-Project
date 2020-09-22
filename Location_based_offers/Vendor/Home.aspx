<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Home.aspx.cs" Inherits="Vendor_Home" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Main</title>
  
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <link href="css/style.ie6.css" rel="stylesheet" type="text/css"/>
    <script src="css/script.js" type="text/javascript"></script>
    <script src="css/jquery.js" type="text/javascript"></script>

</head>
<body>
    <form id="form1" runat="server">
    <div id="art-main">
        <div class="cleared reset-box">
        </div>
        <div class="art-bar art-nav">
            <div class="art-nav-outer">
                <div class="art-nav-wrapper">
                    <div class="art-nav-inner">
                        <ul class="art-hmenu">
                            <li><a href="Home.aspx" class="active">Home</a> </li>
                            <li><a href="manage_offer.aspx">Manage Offer</a> </li>
                            <li><a href="view_customer.aspx">View Customer</a> </li>
                           
                             <li><a href="vendor_login.aspx?msg=logout">Logout</a> </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="cleared reset-box">
        </div>
        <div class="art-header">
            <div class="art-header-position">
                <div class="art-header-wrapper">
                    <div class="cleared reset-box">
                    </div>
                    <div class="art-header-inner">
                        <div class="art-logo">
                            <h1 class="art-logo-name">
                                <a href="#">GRAB-ALL</a></h1>
                            <h2 class="art-logo-text">
                                </h2>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="cleared reset-box">
        </div>
        <div class="art-box art-sheet">
            <div class="art-box-body art-sheet-body">
                <div class="art-layout-wrapper">
                    <div class="art-content-layout">
                        <div class="art-content-layout-row">
                            <div class="art-layout-cell art-content">
                                <div class="art-bar art-blockheader">
                                    <h3 class="t">
                                        <a href="#"></a>
                                    </h3>
                                </div>
                                <div class="art-box art-post">
                                    <div class="art-box-body art-post-body">
                                        
                                        <asp:Image ID="Image1" runat="server" Height="411px" 
                                            ImageUrl="~/images/Consultant-Hotel-Suppliers.jpg" Width="846px" />
                                        
                                        
                                        
                                        <div class="cleared">
                                        </div>
                                    </div>
                                </div>
                                <div class="cleared">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="cleared">
                </div>
                <div class="art-footer">
                    <div class="art-footer-body">
                        <a href="#" class="art-rss-tag-icon" title="RSS"></a>
                        <div class="art-footer-text">
                           <%-- <p>
                                <a href="#">Link1</a> | <a href="#">Link2</a> | <a href="#">Link3</a></p>
                            <p>
                                Copyright © 2012. All Rights Reserved.</p>--%>
                        </div>
                        <div class="cleared">
                        </div>
                    </div>
                </div>
                <div class="cleared">
                </div>
            </div>
        </div>
        <div class="cleared">
        </div>
        <p class="art-page-footer">
           <%-- <a href="http://www.artisteer.com/?p=blogger_templates" target="_blank">Blogger Template</a>
            created with Artisteer.</p>--%>
        <div class="cleared">
        </div>
    </div>
    </form>
</body>
</html>
