using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Admin_add_new_vendor : System.Web.UI.Page
{
    private string cs = ConfigurationManager.ConnectionStrings["connect"].ConnectionString;
    SqlConnection con;
    
    public int vendor_id;
    protected void Page_Load(object sender, EventArgs e)
    {
        con = new SqlConnection(cs);
       
        if(!IsPostBack)
        {
            if (Session["aid"]=="")
           {
               Response.Redirect("Admin_login.aspx?logout");
           }
            bindcat();
            if(Request.QueryString["action"]=="edit")
            {
                vendor_id = Convert.ToInt32(Request.QueryString["vendor_id"].ToString());
                using (SqlCommand cmd = new SqlCommand("select * from vendor_master where vendor_id=@vendor_id", con))
                {
                    cmd.Parameters.AddWithValue("@vendor_id", vendor_id);
                    using(SqlDataAdapter da=new SqlDataAdapter(cmd))
                    {
                        DataTable dt = new DataTable();
                        da.Fill(dt);
                        if(dt.Rows.Count>0)
                        {
                            txtv_name.Text = dt.Rows[0]["vname"].ToString();
                            txtContact_no.Text = dt.Rows[0]["vcontact"].ToString();
                            txtLocation.Text = dt.Rows[0]["vlocation"].ToString();
                            txtdescription.Text = dt.Rows[0]["vdescription"].ToString();
                            txtEmail_id.Text = dt.Rows[0]["vemail"].ToString();
                            txtpassword.Text = dt.Rows[0]["vpassword"].ToString();
                            txtLongitude.Text = dt.Rows[0]["vlongitude"].ToString();
                            txtLatitude.Text = dt.Rows[0]["vlatitude"].ToString();
                        }
                    }
                }

            }
        }
    }
    public void bindcat()
    {
        con = new SqlConnection(cs);
        using (SqlCommand cmd = new SqlCommand("select * from category_master", con))
        {
            DataTable dt = new DataTable();
            SqlDataAdapter da = new SqlDataAdapter(cmd);
            da.Fill(dt);
            if (dt.Rows.Count > 0)
            {
                ddwncat.DataSource = dt;
                ddwncat.DataValueField = "cat_id";
                ddwncat.DataTextField = "category";
                ddwncat.DataBind();
            }

        }
        ddwncat.Items.Insert(0, new ListItem("Select Category", ""));

    }
    protected void btnSave_Click(object sender, EventArgs e)
    {
    
                if (Request.QueryString["action"] == "edit")
                {
                    vendor_id = Convert.ToInt32(Request.QueryString["vendor_id"].ToString());
                    con = new SqlConnection(cs);

                    using (SqlCommand cmd = new SqlCommand("Update vendor_master set vname=@vname,cat_id=@cat_id,vcontact=@vcontact,vlocation=@vlocation,vdescription=@vdescription,vemail=@vemail,vpassword=@vpassword,vlongitude=@vlongitude,vlatitude=@vlatitude where vendor_id=@vendor_id", con))
                    {
                        cmd.Parameters.AddWithValue("@vname", txtv_name.Text);
                        cmd.Parameters.AddWithValue("@vcontact", txtContact_no.Text);
                        cmd.Parameters.AddWithValue("@vlocation", txtLocation.Text);
                        cmd.Parameters.AddWithValue("@vdescription", txtdescription.Text);
                        cmd.Parameters.AddWithValue("@vemail", txtEmail_id.Text);
                        cmd.Parameters.AddWithValue("@vpassword", txtpassword.Text);
                        cmd.Parameters.AddWithValue("@vlongitude", txtLongitude.Text);
                        cmd.Parameters.AddWithValue("@vlatitude", txtLatitude.Text);
                        cmd.Parameters.AddWithValue("@vendor_id", vendor_id);
                        cmd.Parameters.AddWithValue("@cat_id", ddwncat.SelectedValue);
                        con.Open();
                        cmd.ExecuteNonQuery();

                        con.Close();
                        Response.Redirect("Manage_vendor.aspx?msg=update");
                    }


                }
                else
                {
                    con = new SqlConnection(cs);
                    using (SqlCommand cmd2 = new SqlCommand("select * from [vendor_master] where [vname]=@vname and [cat_id]=@cat_id", con))
                    {
                        cmd2.Parameters.AddWithValue("@vname", txtv_name.Text);
                        cmd2.Parameters.AddWithValue("@cat_id", ddwncat.SelectedValue);


                        DataTable dt = new DataTable();
                        SqlDataAdapter da = new SqlDataAdapter(cmd2);
                        da.Fill(dt);
                        if (dt.Rows.Count > 0)
                        {
                            Response.Write("<script>alert('Select vendor name aleardy exist')</script>");

                        }
                        else
                        {
                            
                    using (SqlCommand cmd1 = new SqlCommand("insert into vendor_master([vname],[cat_id],[vcontact],[vlocation],[vdescription],[vemail],[vpassword],[vlongitude],[vlatitude])values(@vname,@cat_id,@vcontact,@vlocation,@vdescription,@vemail,@vpassword,@vlongitude,@vlatitude)", con))
                    {
                        cmd1.Parameters.AddWithValue("@vname", txtv_name.Text);
                        cmd1.Parameters.AddWithValue("@vcontact", txtContact_no.Text);
                        cmd1.Parameters.AddWithValue("@vlocation", txtLocation.Text);
                        cmd1.Parameters.AddWithValue("@vdescription", txtdescription.Text);
                        cmd1.Parameters.AddWithValue("@vemail", txtEmail_id.Text);
                        cmd1.Parameters.AddWithValue("@vpassword", txtpassword.Text);
                        cmd1.Parameters.AddWithValue("@vlongitude", txtLongitude.Text);
                        cmd1.Parameters.AddWithValue("@vlatitude", txtLatitude.Text);
                        cmd1.Parameters.AddWithValue("@cat_id", ddwncat.SelectedValue);
                        con.Open();
                        cmd1.ExecuteNonQuery();
                        con.Close();
                        Response.Redirect("Manage_vendor.aspx?msg=save");

                    }
                        }



                }

            }
        



       
    }
    protected void btnCancel_Click(object sender, EventArgs e)
    {
        Response.Redirect("Manage_vendor.aspx");

    }
}