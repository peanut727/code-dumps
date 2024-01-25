using System.Runtime.InteropServices;

namespace autoclicker
{
    public partial class Form1 : Form
    {
        [DllImport("user32.dll", CharSet = CharSet.Auto, CallingConvention = CallingConvention.StdCall)]
        public static extern void mouse_event(int dwFlags, int dx, int dy, int cButtons, int dwExtraInfo);

        [DllImport("user32.dll")]
        static extern short GetAsyncKeyState(Keys vKey);

        private const int LEFTUP = 0x0004;
        private const int LEFTDOWN = 0x0002;
        public int intervals = 5;
        public bool Click = false;


        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            label1.Text = "Enabled";
        }

        /*private void Autoclicker_Tick(object sender, EventArgs e)
        {
            if (!Bounds.Contains(PointToClient(MousePosition)))
            {
                mouse_event(0x02, 0, 0, 0, 0);
                System.Threading.Thread.Sleep(10);
                mouse_event(0x04, 0, 0, 0, 0);
            }
        }*/

        private void button2_Click(object sender, EventArgs e)
        {
            label1.Text = "disabled";
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            CheckForIllegalCrossThreadCalls = false;
            Thread AC = new Thread(AutoClick);
            AC.Start();
            backgroundWorker1.RunWorkerAsync();
        }

        private void AutoClick()
        {
            while (true)
            {
                if (Click = true)
                {
                    mouse_event(dwFlags: LEFTUP, dx: 0, dy: 0, cButtons: 0, dwExtraInfo: 0);
                    Thread.Sleep(1);
                    mouse_event(dwFlags: LEFTDOWN, dx: 0, dy: 0, cButtons: 0, dwExtraInfo: 0);
                    Thread.Sleep(intervals);
                }
                Thread.Sleep(1);
            }
        }

        private void backgroundWorker1_DoWork(object sender, System.ComponentModel.DoWorkEventArgs e)
        {
            while (true)
            {
                if (label1.Text == "Enabled")
                {
                    if (GetAsyncKeyState(Keys.Down) < 0)
                    {
                        Click = false;
                    }
                    else if (GetAsyncKeyState(Keys.Up) < 0)
                    {
                        Click = true;
                    }
                    Thread.Sleep(1);
                }
            }
        }

        private void button3_Click(object sender, EventArgs e)
        {
            
        }
    }
}
