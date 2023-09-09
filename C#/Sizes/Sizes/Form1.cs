namespace Sizes
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        functions func = new functions();


        private void button1_Click(object sender, EventArgs e)
        {

            func.setOP(Convert.ToDouble(textBox1.Text), Convert.ToDouble(textBox3.Text), textBox2.Text);
            func.calcOP();
            func.getSize();

        }
    }
}