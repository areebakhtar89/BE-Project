using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Vendor_add_new_offer : System.Web.UI.Page
{
    private string cs = ConfigurationManager.ConnectionStrings["connect"].ConnectionString;
    SqlConnection con;
    public int offer_id;
    protected void Page_Load(object sender, EventArgs e)
    {
        con = new SqlConnection(cs);
        if(!IsPostBack)
        {
            if (Session["vid"]=="")
            {
                Response.Redirect("vendor_login.aspx?logout");
            }
            if (Request.QueryString["action"] == "edit")
            {
                offer_id = Convert.ToInt32(Request.QueryString["offer_id"].ToString());
                using (SqlCommand cmd = new SqlCommand("select * from offer_details where offer_id=@offer_id", con))
                {
                    cmd.Parameters.AddWithValue("@offer_id", offer_id);
                    using (SqlDataAdapter da = new SqlDataAdapter(cmd))
                    {
                        DataTable dt = new DataTable();
                        da.Fill(dt);
                        if (dt.Rows.Count > 0)
                        {
                            txtname.Text = dt.Rows[0]["offname"].ToString();
                            txtprice.Text = dt.Rows[0]["offprice"].ToString();
                            txtdescription.Text = dt.Rows[0]["offdescription"].ToString();
                            txtfromdate.Text = dt.Rows[0]["offstartdate"].ToString();
                            txttodate.Text = dt.Rows[0]["offlastdate"].ToString();
                         
                            showimge.ImageUrl = dt.Rows[0]["image"].ToString();
                           
                        }
                    }
                }


            }


            
        }
    }
    
  
    protected void btnSave_Click(object sender, EventArgs e)
    {
         string image = "";
        if (Request.QueryString["action"] == "edit")
        {
            offer_id = Convert.ToInt32(Request.QueryString["offer_id"].ToString());
            string vendor_id = Session["vid"].ToString();
            con = new SqlConnection(cs);


            using (SqlCommand cmd = new SqlCommand("Update offer_details set vendor_id=@vendor_id,offname=@offname,offprice=@offprice,offdescription=@offdescription,offstartdate=@offstartdate,offlastdate=@offlastdate,image=@image where offer_id=@offer_id", con))
            {
                cmd.Parameters.AddWithValue("@offer_id", offer_id);
                cmd.Parameters.AddWithValue("@vendor_id", vendor_id);
                cmd.Parameters.AddWithValue("@offname",txtname.Text);
                cmd.Parameters.AddWithValue("@offprice",txtprice.Text);
                cmd.Parameters.AddWithValue("@offdescription",txtdescription.Text);


                string dateString = txtfromdate.Text;
                DateTime date1 = Convert.ToDateTime(dateString, System.Globalization.CultureInfo.GetCultureInfo("hi-IN").DateTimeFormat);

                cmd.Parameters.AddWithValue("@offstartdate", date1);

                string dateString1 = txttodate.Text;
                DateTime date2 = Convert.ToDateTime(dateString1, System.Globalization.CultureInfo.GetCultureInfo("hi-IN").DateTimeFormat);
                cmd.Parameters.AddWithValue("@offlastdate", date2);
             
                if (fileuplogo.HasFile)
                {
                    string str = fileuplogo.FileName;
                    fileuplogo.PostedFile.SaveAs(Server.MapPath("images/" + str));
                    image = "images/" + str.ToString();
                }
                cmd.Parameters.AddWithValue("@image",image);
               
                con.Open();
                cmd.ExecuteNonQuery();

                con.Close();
                Response.Redirect("manage_offer.aspx?msg=update");
            }


        }
        else
        {
            con = new SqlConnection(cs);
            string vendor_id = Session["vid"].ToString();
            using (SqlCommand cmd1 = new SqlCommand("insert into offer_details(vendor_id,offname,offprice,offdescription,offstartdate,offlastdate,image)values(@vendor_id,@offname,@offprice,@offdescription,@offstartdate,@offlastdate,@image)", con))
            {
                cmd1.Parameters.AddWithValue("@vendor_id",vendor_id);
                cmd1.Parameters.AddWithValue("@offname",txtname.Text);
                cmd1.Parameters.AddWithValue("@offprice",txtprice.Text);
                cmd1.Parameters.AddWithValue("@offdescription",txtdescription.Text);

                string dateString = txtfromdate.Text;
                DateTime date1 = Convert.ToDateTime(dateString, System.Globalization.CultureInfo.GetCultureInfo("hi-IN").DateTimeFormat);

                cmd1.Parameters.AddWithValue("@offstartdate", date1);

                string dateString1 = txttodate.Text;
                DateTime date2 = Convert.ToDateTime(dateString1, System.Globalization.CultureInfo.GetCultureInfo("hi-IN").DateTimeFormat);
                cmd1.Parameters.AddWithValue("@offlastdate", Convert.ToDateTime(date2));
            

                 if (fileuplogo.HasFile)
                {
                    string str = fileuplogo.FileName;
                    fileuplogo.PostedFile.SaveAs(Server.MapPath("images/" + str));
                    image = "images/" + str.ToString();
                }
                 cmd1.Parameters.AddWithValue("@image", image);
             
                con.Open();
                cmd1.ExecuteNonQuery();
                con.Close();
                Response.Redirect("manage_offer.aspx?msg=save");

            }


        }
    }
    protected void btnCancel_Click(object sender, EventArgs e)
    {
        Response.Redirect("manage_offer.aspx");
    }
}