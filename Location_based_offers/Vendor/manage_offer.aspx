<%@ Page Language="C#" AutoEventWireup="true" CodeFile="manage_offer.aspx.cs" Inherits="Vendor_manage_offer" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Offer</title>
   
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
                                        <a href="add_new_offer.aspx">Add New Offer</a>
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
                                                <asp:BoundField DataField="offer_id" HeaderText="Offer_id" InsertVisible="False" ReadOnly="True"
                                                    SortExpression="offer_id">
                                                    <HeaderStyle HorizontalAlign="Left" />
                                                </asp:BoundField>
                                                <asp:BoundField DataField="offname" HeaderText="Name" SortExpression="Name">
                                                    <HeaderStyle HorizontalAlign="Left" />
                                                </asp:BoundField>
                                              
                                                <asp:BoundField DataField="offprice" HeaderText="Price" SortExpression="Price">
                                                    <HeaderStyle HorizontalAlign="Left" />
                                                </asp:BoundField>
                                                <asp:BoundField DataField="offdescription" HeaderText="Description" SortExpression="description">
                                                    <HeaderStyle HorizontalAlign="Left" />
                                                </asp:BoundField>
                                                <asp:BoundField DataField="offstartdate" HeaderText="Start Date" SortExpression="From">
                                                    <HeaderStyle HorizontalAlign="Left" />
                                                </asp:BoundField>
                                                <asp:BoundField DataField="offlastdate" HeaderText="Last To" SortExpression="To">
                                                    <HeaderStyle HorizontalAlign="Left" />
                                                </asp:BoundField>
                                             
                                                  <asp:ImageField DataImageUrlField="image" HeaderText="Photo" SortExpression="Photo" ControlStyle-Width="28" ControlStyle-Height = "28"/>
                                                     

                                                <asp:HyperLinkField HeaderText="Action" Text="Edit" DataNavigateUrlFields="offer_id"
                                                    DataNavigateUrlFormatString="add_new_offer.aspx?action=edit&amp;offer_id={0}">
                                                    <HeaderStyle HorizontalAlign="Left" />
                                                </asp:HyperLinkField>
                                                <asp:TemplateField HeaderText="">
                                                    <ItemTemplate>
                                                        <asp:LinkButton ID="DeleteButton" runat="server" CausesValidation="False" CommandArgument='<%#Eval("offer_id") %>'
                                                            OnCommand="Delete_row" CommandName="Delete"  Text="Delete" OnClientClick="return confirm('Are you certain you want to delete this?');"></asp:LinkButton></ItemTemplate>
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
                                            SelectCommand="select * from offer_details WHERE ([vendor_id] = @vendor_id)"
                                            DeleteCommand="delete from offer_details where offer_id=@offer_id">
                                            <DeleteParameters>
                                                <asp:Parameter Name="offer_id"/>
                                            </DeleteParameters>
                                            <SelectParameters>
                                                <asp:SessionParameter Name="vendor_id" SessionField="vid" Type="Int32" />
                                            </SelectParameters>
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
