<%@ Page Language="C#" AutoEventWireup="true" CodeFile="add_new_offer.aspx.cs" Inherits="Vendor_add_new_offer" %>

<%@ Register Namespace="AjaxControlToolkit" Assembly="AjaxControlToolkit" TagPrefix="ajax" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Add_Offer</title>
  

    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <link href="css/style.ie6.css" rel="stylesheet" type="text/css"/>
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
    <div runat="server">
      <script type="text/javascript">
          var chkvalue = "";


          function showimg() {
              debugger;
              var showimage = document.querySelector('#<%=showimge.ClientID %>');
            var file = document.querySelector('#<%=fileuplogo.ClientID%>').files[0];

            var reader = new window.FileReader();

            reader.onload = function () {
                showimage.src = reader.result;

            }
            if (file) {
                //reader.readasdataurl(file);
                reader.readAsDataURL(file);

            }
            else {
                showimage.src = "";
            }
        }

    </script>
    </div>
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
                                                     Name:<asp:Label ID="Label1" runat="server" Text="*"></asp:Label></td>
                                                <td class="style3">
                                                    <asp:TextBox ID="txtname" runat="server" MaxLength="30"></asp:TextBox>
                                                     </td>
                                                <td>
                                                    <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" 
                                                        ControlToValidate="txtname" ErrorMessage="Fill Name"></asp:RequiredFieldValidator>
                                                     &nbsp;</td>
                                            </tr>
                                         
                                                <tr>
                                                <td class="style2">
                                                    Price:<asp:Label ID="Label3" runat="server" Text="*"></asp:Label></td>
                                                <td class="style3">
                                                    <asp:TextBox ID="txtprice" runat="server" MaxLength="10"></asp:TextBox>
                                                     </td>
                                                <td>
                                                    <asp:RequiredFieldValidator ID="RequiredFieldValidator3" runat="server" 
                                                        ControlToValidate="txtprice" ErrorMessage="Fill Price"></asp:RequiredFieldValidator>
                                                  
                                                     </td>
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
                                                    From Date:<asp:Label ID="Label8" runat="server" Text="*"></asp:Label></td>
                                                <td class="style3">
                                                   
                                                    <asp:TextBox ID="txtfromdate" runat="server"></asp:TextBox>
                                                      <ajax:CalendarExtender ID="CalendarExtender2" runat="server" TargetControlID="txtfromdate"
                                    Format="dd/MM/yyyy">
                                </ajax:CalendarExtender>
                                                     </td>
                                                <td>
                                                    <asp:RequiredFieldValidator ID="RequiredFieldValidator9" runat="server" 
                                                        ControlToValidate="txtfromdate" ErrorMessage="Fill From Date"></asp:RequiredFieldValidator>
                                                  
                                                     </td>
                                            </tr>
                                  
                                                <tr>
                                                <td class="style2">
                                                    To Date:<asp:Label ID="Label7" runat="server" Text="*"></asp:Label></td>
                                                <td class="style3">
                                                     <asp:ScriptManager ID="ScriptManager1" runat="server"></asp:ScriptManager>
                                                    <asp:TextBox ID="txttodate" runat="server"></asp:TextBox>
                                                     <ajax:CalendarExtender ID="CalendarExtender1" runat="server" TargetControlID="txttodate"
                                    Format="dd/MM/yyyy">
                                </ajax:CalendarExtender>
                                                     </td>
                                                <td>
                                                    <asp:RequiredFieldValidator ID="RequiredFieldValidator8" runat="server" 
                                                        ControlToValidate="txttodate" ErrorMessage="Fill Longitude"></asp:RequiredFieldValidator>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="style2">
                                                    Photo:<asp:Label ID="Label6" runat="server" Text="*"></asp:Label></td>
                                                <td class="style3">
                                                    <asp:Image ID="showimge" runat="server" Height="50" Width="100" />
                 
                                                    <asp:FileUpload ID="fileuplogo" runat="server" onchange="showimg()" />
                                                     </td>
                                             
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
                          <%--  <p>
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
