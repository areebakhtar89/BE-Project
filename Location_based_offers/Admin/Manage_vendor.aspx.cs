using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Admin_Manage_vendor : System.Web.UI.Page
{
    private string cs = ConfigurationManager.ConnectionStrings["connect"].ConnectionString;
    SqlConnection con;
    protected void Page_Load(object sender, EventArgs e)
    {
        if(!IsPostBack)
        {
            if (Session["aid"]=="")
            {
                Response.Redirect("Admin_login.aspx?logout");
            }
            if(Request.QueryString["msg"]=="save")
            {
                lblShow.Text = "Data add successfully";
            }
            if (Request.QueryString["msg"] == "update")
            {
                lblShow.Text = "Data update successfully";
            }
        }
    }

    protected void Delete_row(object sender, CommandEventArgs e)
    {
        con = new SqlConnection(cs);

        if (e.CommandName == "Delete")
        {
            using (SqlCommand cmd = new SqlCommand("Delete from vendor_master where vendor_id="+e.CommandArgument+"", con))
            {
                con.Open();
                cmd.ExecuteNonQuery();
                con.Close();
                Response.Redirect("Manage_vendor.aspx");
            }

        }
    

    }
}