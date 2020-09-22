<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Manage_vendor.aspx.cs" Inherits="Admin_Manage_vendor" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Vendor</title>
   
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
                    <div class="art-nav-inner">
                        <ul class="art-hmenu">
                            <li><a href="Home.aspx" class="active">Home</a></li>
                            <li><a href="Manage_vendor.aspx">Manage Vendor</a></li>
                               <li><a href="view_customer.aspx">View Customer</a></li>
                            <li><a href="viewregister_offer.aspx">Registered Offer</a> </li>
                            <li><a href="Admin_login.aspx?msg=logout">Logout</a></li>
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
                                        <a href="add_new_vendor.aspx">Add New Vendor</a>
                                    </h3>
                                </div>
                                <div class="art-box art-post">
                                    <asp:Label ID="lblShow" runat="server" Text=""></asp:Label>
                                    <div class="art-box-body art-post-body">
                                        <asp:GridView ID="GridView1" runat="server" AllowSorting="True" AutoGenerateColumns="False"
                                            BackColor="LightGoldenrodYellow" BorderColor="Tan" BorderWidth="1px" CellPadding="2"
                                            DataSourceID="SqlDataSource1" ForeColor="Black" GridLines="None" Width="870px"
                                            AllowPaging="True">
                                            <Columns>
                                                <asp:BoundField DataField="vendor_id" HeaderText="Vendor_id" InsertVisible="False" ReadOnly="True"
                                                    SortExpression="vendor_id">
                                                    <HeaderStyle HorizontalAlign="Left" />
                                                </asp:BoundField>
                                                <asp:BoundField DataField="vname" HeaderText="Name" SortExpression="Name">
                                                    <HeaderStyle HorizontalAlign="Left" />
                                                </asp:BoundField>
                                                   <asp:BoundField DataField="Category" HeaderText="Category" SortExpression="Category">
                                                    <HeaderStyle HorizontalAlign="Left" />
                                                </asp:BoundField>
                                                <asp:BoundField DataField="vcontact" HeaderText="Contact No" SortExpression="Contact_no">
                                                    <HeaderStyle HorizontalAlign="Left" />
                                                </asp:BoundField>
                                                <asp:BoundField DataField="vemail" HeaderText="Email_id" SortExpression="Email_id">
                                                    <HeaderStyle HorizontalAlign="Left" />
                                                </asp:BoundField>
                                                <asp:BoundField DataField="vdescription" HeaderText="Description" SortExpression="Description">
                                                    <HeaderStyle HorizontalAlign="Left" />
                                                </asp:BoundField>
                                                <asp:BoundField DataField="vlocation" HeaderText="Address" SortExpression="Location">
                                                    <HeaderStyle HorizontalAlign="Left" />
                                                </asp:BoundField>
                                                <asp:HyperLinkField HeaderText="Action" Text="Edit" DataNavigateUrlFields="vendor_id"
                                                    DataNavigateUrlFormatString="add_new_vendor.aspx?action=edit&amp;vendor_id={0}">
                                                    <HeaderStyle HorizontalAlign="Left" />
                                                </asp:HyperLinkField>
                                                <asp:TemplateField HeaderText="">
                                                    <ItemTemplate>
                                                        <asp:LinkButton ID="DeleteButton" runat="server" CausesValidation="False" CommandArgument='<%#Eval("vendor_id") %>'
                                                          OnCommand="Delete_row"  CommandName="Delete"  Text="Delete" OnClientClick="return confirm('Are you certain you want to delete this?');"></asp:LinkButton></ItemTemplate>
                                                    <ItemStyle HorizontalAlign="Center" VerticalAlign="Middle" Width="10%" />
                                                    
                                                </asp:TemplateField>
                                            </Columns>
                                            <FooterStyle BackColor="Tan" />
                                            <PagerStyle BackColor="PaleGoldenrod" ForeColor="DarkSlateBlue" HorizontalAlign="Center" />
                                            <SelectedRowStyle BackColor="DarkSlateBlue" ForeColor="GhostWhite" />
                                            <HeaderStyle BackColor="Tan" Font-Bold="True" />
                                            <AlternatingRowStyle BackColor="PaleGoldenrod" />
                                        </asp:GridView>
                                        <asp:SqlDataSource ID="SqlDataSource1" runat="server" ConnectionString="<%$ ConnectionStrings:connect %>"
                                            SelectCommand="select vm.[vendor_id],vm.[vname],vm.[vcontact],vm.[vlocation],vm.[vdescription],vm.[vemail],vm.[vpassword],vm.[vlongitude],vm.[vlatitude],vm.[cat_id],cm.[category] from [vendor_master] vm inner join [category_master] cm on vm.[cat_id]=cm.[cat_id]"
                                            DeleteCommand="delete from vendor_master where vendor_id=@vendor_id">
                                            <DeleteParameters>
                                                <asp:Parameter Name="vendor_id"/>
                                            </DeleteParameters>
                                        </asp:SqlDataSource>
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
