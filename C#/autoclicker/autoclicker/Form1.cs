using System.Runtime.InteropServices;

namespace autoclicker
{
    public partial class Form1 : Form
    {
        [DllImport("user32.dll")]
        private static extern void mouse_event(int dwFlags, int dx, int dy, int dwData, int dwExtraInfo);
        private bool on;

        public Form1()
        {
            InitializeComponent();
        }

        private void OnMouseDown(object sender, MouseEventArgs e)
        {
            if (e.Button == MouseButtons.Left)
            {
                Autoclicker.Start();
            }
        }
        private void OnMouseUp(object sender, MouseEventArgs e)
        {
            if (e.Button == MouseButtons.Right)
            {
                Autoclicker.Stop();
            }
        }

        private void start()
        {
            Autoclicker.Interval = (int)1000.0 / Convert.ToInt32(textBox1.Text);
            Autoclicker.Start();
            button1.Enabled = false;
            button2.Enabled = true;
            
          
           

        }
        private void stop()
        {
            Autoclicker.Stop();
            button1.Enabled = true;
            button2.Enabled = false;
        }

        private void button1_Click(object sender, EventArgs e)
        { 
            start();
        }

        private void Autoclicker_Tick(object sender, EventArgs e)
        {
            if (!Bounds.Contains(PointToClient(MousePosition)))
            {
                mouse_event(0x02, 0, 0, 0, 0);
                System.Threading.Thread.Sleep(10);
                mouse_event(0x04, 0, 0, 0, 0);
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            stop();
            on = false;
        }
    }
}
