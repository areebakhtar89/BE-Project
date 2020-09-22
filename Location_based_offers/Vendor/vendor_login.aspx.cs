using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Vendor_vendor_login : System.Web.UI.Page
{
    private string cs = ConfigurationManager.ConnectionStrings["connect"].ConnectionString;
    SqlConnection con;
    protected void Page_Load(object sender, EventArgs e)
    {
        if (!IsPostBack)
        {
            Session.Abandon();
            Session.Clear();

            if (Request.QueryString["msg"] == "logout")
            {
                Response.Redirect("vendor_login.aspx");
            }
        }
      
    }
    protected void btnLogin_Click(object sender, EventArgs e)
    {
        con = new SqlConnection(cs);
        using (SqlCommand cmd = new SqlCommand("select * from vendor_master where vemail=@vemail and vpassword=@vpassword", con))
        {
            DataTable dt = new DataTable();
            cmd.Parameters.AddWithValue("@vemail", txtUsername.Text);
            cmd.Parameters.AddWithValue("@vpassword", txtPassword.Text);
            using (SqlDataAdapter sda = new SqlDataAdapter(cmd))
            {
                sda.Fill(dt);
            }
            if (dt.Rows.Count > 0)
            {
                Session["vid"] = dt.Rows[0]["vendor_id"].ToString();
                Response.Redirect("Home.aspx");
            }
            else
            {
                Response.Write("<script>alert('Invalid Login')</script>");
            }
        }
    }
}