using System.Collections;

namespace StackTest
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        static Stack stack = new Stack();
        private void button1_Click(object sender, EventArgs e)
        {
            string text = textBox1.Text;

            if (text == null)
            {
                MessageBox.Show("No values!");

            }
            else if (listBox1.Items.Contains(text))
            {
                MessageBox.Show("Duplicated values!");
            }
            else
            {
                stack.Push(textBox1.Text);

                foreach (var item in stack)
                {
                    listBox1.Items.Add(item);
                    break;
                }
            }

        }

        private void button2_Click(object sender, EventArgs e)
        {
            if (stack.Count > 0)
            {
                foreach (var item in stack)
                {
                    stack.Pop();
                    listBox1.Items.Remove(item);
                    break;
                }
            }
            else
            {
                MessageBox.Show("Stack has no stored values.");
            }
        }
    }
}