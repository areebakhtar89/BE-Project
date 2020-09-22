<%@ Page Language="C#" AutoEventWireup="true" CodeFile="viewregister_offer.aspx.cs" Inherits="Vendor_viewregister_offer" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
    <head runat="server">
    <title>Customer</title>
   
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
                            <li><a href="viewregister_offer.aspx">View Registered Customer</a> </li>
                           
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
                                        <a href="#">Register Offers List</a>
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
                                                <asp:BoundField DataField="off_regis_id" HeaderText="Id" InsertVisible="False" ReadOnly="True"
                                                    SortExpression="Id">
                                                    <HeaderStyle HorizontalAlign="Left" />
                                                </asp:BoundField>
                                                <asp:BoundField DataField="customer_id" HeaderText="Customer Name" SortExpression="Name">
                                                    <HeaderStyle HorizontalAlign="Left" />
                                                </asp:BoundField>
                                                <asp:BoundField DataField="offname" HeaderText="Offer Name" SortExpression="Offer Name">
                                                    <HeaderStyle HorizontalAlign="Left" />
                                                </asp:BoundField>
                                                <asp:BoundField DataField="offdescription" HeaderText="Description" SortExpression="description">
                                                    <HeaderStyle HorizontalAlign="Left" />
                                                </asp:BoundField>
                                              
                                            </Columns>
                                            <FooterStyle BackColor="Tan" />
                                            <PagerStyle BackColor="PaleGoldenrod" ForeColor="DarkSlateBlue" HorizontalAlign="Center" />
                                            <SelectedRowStyle BackColor="DarkSlateBlue" ForeColor="GhostWhite" />
                                            <HeaderStyle BackColor="Tan" Font-Bold="True" />
                                            <AlternatingRowStyle BackColor="PaleGoldenrod" />
                                        </asp:GridView>
                                        <asp:SqlDataSource ID="SqlDataSource1" runat="server" ConnectionString="<%$ ConnectionStrings:connect %>"
                                            SelectCommand="SELECT * FROM [Registered_offer]"
                                            DeleteCommand="delete from offer_details where offer_id=@offer_id">
                                            <DeleteParameters>
                                                <asp:Parameter Name="offer_id"/>
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
