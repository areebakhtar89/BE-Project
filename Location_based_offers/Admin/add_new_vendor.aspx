<%@ Page Language="C#" AutoEventWireup="true" CodeFile="add_new_vendor.aspx.cs" Inherits="Admin_add_new_vendor" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Add_Vendor</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <link href="css/style.ie6.css" rel="stylesheet" type="text/css" />
    <style type="text/css">
        .style1
        {
            width: 100%;
        }
        .style2
        {
            width: 136px;
        }
        .style3
        {
            width: 220px;
        }
    </style>
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
                            <li><a href="Manage_vendor.aspx">Manage Vendor</a> </li>
                            <li><a href="Manage_offer.aspx">View Customer</a> </li>
                              <li><a href="viewregister_offer.aspx">Registered Offer</a> </li>
                             <li><a href="Admin_login.aspx?msg=logout">Logout</a> </li>
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
                                <a href="#">GRAB-ALL Advertisement</a></h1>
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
                                        
                                        
                                        
                                        
                                        <table class="style1" cellpadding="10" cellspacing="4">
                                            <tr>
                                                <td class="style2">
                                                    &nbsp;</td>
                                                <td class="style3">
                                                    <asp:Label ID="lblShow" runat="server" ForeColor="Red"></asp:Label>
                                                     </td>
                                                <td>
                                                    &nbsp;</td>
                                            </tr>
                                            <tr>
                                                <td class="style2">
                                                    Vendor Name:<asp:Label ID="Label1" runat="server" Text="*"></asp:Label></td>
                                                <td class="style3">
                                                    <asp:TextBox ID="txtv_name" runat="server" MaxLength="30"></asp:TextBox>
                                                     </td>
                                                <td>
                                                    <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" 
                                                        ControlToValidate="txtv_name" ErrorMessage="Fill Vendor Name"></asp:RequiredFieldValidator>
                                                     &nbsp;</td>
                                            </tr>
                                                 <tr>
                                                <td class="style2">
                                                     Category:<asp:Label ID="Label9" runat="server" Text="*"></asp:Label></td>
                                                <td class="style3">
                                                    <asp:DropDownList ID="ddwncat" runat="server"></asp:DropDownList>
                                                     </td>
                                                <td>
                                                    <asp:RequiredFieldValidator ID="RequiredFieldValidator5" runat="server" 
                                                        ControlToValidate="ddwncat" ErrorMessage="select category"></asp:RequiredFieldValidator>
                                                     &nbsp;</td>
                                            </tr>
                                                <tr>
                                                <td class="style2">
                                                    Contact No:<asp:Label ID="Label3" runat="server" Text="*"></asp:Label></td>
                                                <td class="style3">
                                                    <asp:TextBox ID="txtContact_no" runat="server" MaxLength="10"></asp:TextBox>
                                                     </td>
                                                <td>
                                                    <asp:RequiredFieldValidator ID="RequiredFieldValidator3" runat="server" 
                                                        ControlToValidate="txtContact_no" ErrorMessage="Fill Contact No."></asp:RequiredFieldValidator>
                                                    <asp:RegularExpressionValidator ID="RegularExpressionValidator2" runat="server" 
                                                        ControlToValidate="txtContact_no" ErrorMessage="Invalid Contact No." 
                                                        ValidationExpression="^[0-9]{10}"></asp:RegularExpressionValidator>
                                                     </td>
                                            </tr>
                                            <tr>
                                                <td class="style2">
                                                    Location:<asp:Label ID="Label5" runat="server" Text="*"></asp:Label></td>
                                                <td class="style3">
                                                    <asp:TextBox ID="txtLocation" runat="server"></asp:TextBox>
                                                     </td>
                                                <td>
                                                    <asp:RequiredFieldValidator ID="RequiredFieldValidator6" runat="server" 
                                                        ControlToValidate="txtLocation" ErrorMessage="Fill Location"></asp:RequiredFieldValidator>
                                                     &nbsp;</td>
                                            </tr>
                                                <tr>
                                                <td class="style2">
                                                    Description:<asp:Label ID="Label2" runat="server" Text="*"></asp:Label></td>
                                                <td class="style3">
                                                    <asp:TextBox ID="txtdescription" runat="server" ></asp:TextBox>
                                                     </td>
                                                <td>
                                                    <asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" 
                                                        ControlToValidate="txtdescription" ErrorMessage="Fill Description"></asp:RequiredFieldValidator>
                                                  
                                                     </td>
                                            </tr>
                                        
                                            <tr>
                                                <td class="style2">
                                                    Email ID:<asp:Label ID="Label4" runat="server" Text="*"></asp:Label></td>
                                                <td class="style3">
                                                    <asp:TextBox ID="txtEmail_id" runat="server"></asp:TextBox>
                                                     </td>
                                                <td>
                                                    <asp:RequiredFieldValidator ID="RequiredFieldValidator4" runat="server" 
                                                        ControlToValidate="txtEmail_id" ErrorMessage="Fill Email id"></asp:RequiredFieldValidator>
                                                    <asp:RegularExpressionValidator ID="RegularExpressionValidator1" runat="server" 
                                                        ControlToValidate="txtEmail_id" ErrorMessage="Invalid Email Id" 
                                                        ValidationExpression="\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*"></asp:RegularExpressionValidator>
                                                     </td>
                                            </tr>
                                                       <tr>
                                                <td class="style2">
                                                    Password:<asp:Label ID="Label8" runat="server" Text="*"></asp:Label></td>
                                                <td class="style3">
                                                    <asp:TextBox ID="txtpassword" runat="server" ></asp:TextBox>
                                                     </td>
                                                <td>
                                                    <asp:RequiredFieldValidator ID="RequiredFieldValidator9" runat="server" 
                                                        ControlToValidate="txtpassword" ErrorMessage="Fill Password"></asp:RequiredFieldValidator>
                                                  
                                                     </td>
                                            </tr>
                                  
                                                <tr>
                                                <td class="style2">
                                                    Longitude:<asp:Label ID="Label7" runat="server" Text="*"></asp:Label></td>
                                                <td class="style3">
                                                    <asp:TextBox ID="txtLongitude" runat="server"></asp:TextBox>
                                                     </td>
                                                <td>
                                                    <asp:RequiredFieldValidator ID="RequiredFieldValidator8" runat="server" 
                                                        ControlToValidate="txtLongitude" ErrorMessage="Fill Longitude"></asp:RequiredFieldValidator>
                                                     &nbsp;<asp:RegularExpressionValidator ID="RegularExpressionValidator4" runat="server" 
                                                        ControlToValidate="txtLongitude" ErrorMessage="Invalid Longitude No" 
                                                        ValidationExpression="^[0-9]*(?:\.[0-9]*)?$"></asp:RegularExpressionValidator>
                                                    </td>
                                            </tr>
                                            <tr>
                                                <td class="style2">
                                                    Latitude:<asp:Label ID="Label6" runat="server" Text="*"></asp:Label></td>
                                                <td class="style3">
                                                    <asp:TextBox ID="txtLatitude" runat="server"></asp:TextBox>
                                                     </td>
                                                <td>
                                                    <asp:RequiredFieldValidator ID="RequiredFieldValidator7" runat="server" 
                                                        ControlToValidate="txtLatitude" ErrorMessage="Fill Latitude"></asp:RequiredFieldValidator>
                                                     &nbsp;<asp:RegularExpressionValidator ID="RegularExpressionValidator5" runat="server" 
                                                        ControlToValidate="txtLatitude" ErrorMessage="Invalid Latitude No." 
                                                        ValidationExpression="^[0-9]*(?:\.[0-9]*)?$"></asp:RegularExpressionValidator></td>
                                            </tr>
                                  
                                   
                                            <tr>
                                                <td class="style2">
                                                    <asp:Button ID="btnSave" runat="server" Text="Save" Width="100px" OnClick="btnSave_Click" />
                                                </td>
                                                <td class="style3">
                                                    <asp:Button ID="btnCancel" runat="server" Text="Cancel" Width="100px" 
                                                        CausesValidation="False" OnClick="btnCancel_Click" />
                                                </td>
                                                <td>
                                                    &nbsp;</td>
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
                            <%--<p>
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
