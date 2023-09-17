using System.Web;

namespace OddEven
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private int var1 = -1;

        private void button1_Click(object sender, EventArgs e)
        {
            string get = textBox1.Text;


            if (get.Length >= 10)
            {

                timer1.Start();

            }
            else
            {
                MessageBox.Show("Not enough numbers!!");
            }



        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            var1++;

            try
            {
                string get = textBox1.Text;
                // It gets the numbers from the string array 
                int number = Convert.ToInt32("" + get[var1]);

                if (var1 < get.Length)
                {
                    
                    if (number % 2 == 0)
                    {
                        // Even numbers goes here
                        listView1.Items.Add("" + number);

                    } 
                    else
                    {
                        // Odd goes here
                        listView2.Items.Add("" + number);
                    }
                }
                else
                {
                    timer1.Stop(); 
                }



            }
            catch (Exception ex)
            {
                timer1.Stop();
                //MessageBox.Show(ex.Message);
            }

        }
    }
}