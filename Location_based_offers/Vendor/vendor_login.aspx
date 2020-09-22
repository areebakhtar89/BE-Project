<%@ Page Language="C#" AutoEventWireup="true" CodeFile="vendor_login.aspx.cs" Inherits="Vendor_vendor_login" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Login</title>
   


    <link href="css/style.css" rel="stylesheet" type="text/css" />
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
                    <center>
                        <h2>
                            Vendor Panel</h2>
                    </center>
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
                                <div class="art-box art-post">
                                    <div class="art-box-body art-post-body">
                                        <table class="style1">
                                            <tr>
                                                <td class="style2">
                                                    &nbsp;
                                                </td>
                                                <td class="style3">
                                                    <asp:Label ID="lblShow" runat="server" ForeColor="Red"></asp:Label>
                                                </td>
                                                <td class="style4">
                                                    &nbsp;
                                                </td>
                                                <td class="style5">
                                                    &nbsp;
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="style2">
                                                    Username:<asp:Label ID="Label1" runat="server" Text="*"></asp:Label>
                                                </td>
                                                <td class="style3">
                                                    <asp:TextBox ID="txtUsername" runat="server"></asp:TextBox>
                                                </td>
                                                <td class="style4">
                                                    <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" ControlToValidate="txtUsername"
                                                        ErrorMessage="Username Required"></asp:RequiredFieldValidator>
                                                </td>
                                                <td class="style5">
                                                    &nbsp;
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="style2">
                                                    Password:<asp:Label ID="Label2" runat="server" Text="*"></asp:Label>
                                                </td>
                                                <td class="style3">
                                                    <asp:TextBox ID="txtPassword" runat="server" TextMode="Password"></asp:TextBox>
                                                </td>
                                                <td class="style4">
                                                    <asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" ControlToValidate="txtPassword"
                                                        ErrorMessage="Password Required"></asp:RequiredFieldValidator>
                                                </td>
                                                <td class="style5">
                                                    &nbsp;
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="style2">
                                                    &nbsp;
                                                </td>
                                                <td class="style3">
                                                    <asp:Button ID="btnLogin" runat="server" Text="Login" Width="76px" OnClick="btnLogin_Click" />
                                                    &nbsp;
                                                    <asp:Button ID="btnCancel" runat="server" Text="Cancel" Width="76px" />
                                                </td>
                                                <td class="style4">
                                                    &nbsp;
                                                </td>
                                                <td class="style5">
                                                    &nbsp;
                                                </td>
                                            </tr>
                                        </table>
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
        <div class="cleared">
        </div>
    </div>
    </form>
</body>
</html>
