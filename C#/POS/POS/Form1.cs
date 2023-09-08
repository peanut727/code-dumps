using POS.Functions;
using System.Text;

namespace POS
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        goods product = new goods();
        private decimal totalPrice = 0.0m;


        private void button1_Click(object sender, EventArgs e)
        {
            try
            {
                int code = Convert.ToInt32(barcode.Text);
                string name = prodname.Text;
                decimal price = Convert.ToDecimal(prodprice.Text);

                if (string.IsNullOrEmpty(barcode.Text) || string.IsNullOrEmpty(prodname.Text) || string.IsNullOrEmpty(prodprice.Text))
                {
                    MessageBox.Show("Missing product information or wrong value");

                }
                else
                {
                    product.addProd(code, name, price);
                    label6.Text = name + " Added";
                }

            }
            catch (Exception ex)
            {
                MessageBox.Show("Invalid Characters");
            }




        }

        private void button2_Click(object sender, EventArgs e)
        {

            int search = Convert.ToInt32(searchNum.Text);
            product.getProd(search);

            string prodname = product.getName();
            decimal price = product.getPrice();



            itemName.Text += prodname + Environment.NewLine;
            itemPrice.Text += "₱" + price.ToString() + Environment.NewLine;

            totalPrice += price;
            totPrice.Text = "₱" + totalPrice.ToString("N2");

        }
    }
}