using Gma.System.MouseKeyHook;
using System;
using System.Diagnostics;
using System.Runtime.CompilerServices;
using System.Runtime.InteropServices;
using System.Windows.Forms;
using System.Xml.Serialization;


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
        public int intervals = 1000 / 20;
        public bool Click = false;
        private IKeyboardMouseEvents events;

        public Form1()
        {
            InitializeComponent();
        }

        private async void Form1_Load(object sender, EventArgs e)
        {
            CheckForIllegalCrossThreadCalls = false;
            //Thread thread = new Thread(AutoClick);
            //thread.Start();
            //backgroundWorker1.RunWorkerAsync();
            Subscribe();
            await AutoClick();

        }

        public void Subscribe()
        {
            events = Hook.GlobalEvents();

            events.MouseDownExt += GlobalHookMouseDown;
            events.MouseUpExt += GlobalHookMouseUp;
            events.MouseClick += GHookClickEnable;
        }
        private void GHookClickEnable(object sender, MouseEventArgs e)
        {
            if (e.Button == MouseButtons.Middle)
            {
                if (isEnabled)
                {

                    Debug.WriteLine("Off");
                    isEnabled = false;

                }
                else
                {
                    Debug.WriteLine("On");
                    isEnabled = true;
                }
            }
        }
        private async Task AutoClick()
        {
            while (true)
            {
                if (Click)
                {
                    mouse_event(dwFlags: LEFTUP, dx: 0, dy: 0, cButtons: 0, dwExtraInfo: 0);
                    await Task.Delay(1);
                    mouse_event(dwFlags: LEFTDOWN, dx: 0, dy: 0, cButtons: 0, dwExtraInfo: 0);
                    await Task.Delay(intervals);
                }
                await Task.Delay(1);
            }

        }
        private bool isEnabled = false;
        private void backgroundWorker1_DoWork(object sender, System.ComponentModel.DoWorkEventArgs e)
        {
            while (true)
            {
                if (isEnabled)
                {
                    //Thread thread = new Thread(AutoClick);
                    //thread.Start();
                }
            }
        }

        private void GlobalHookMouseUp(object sender, MouseEventExtArgs e)
        {
            if (e.Button == MouseButtons.Left && isEnabled)
            {
                Debug.WriteLine("LReleased");
                Click = false;
            }
            else if (e.Button == MouseButtons.Right)
            {
                // MessageBox.Show("RReleased");
            }
        }

        private void GlobalHookMouseDown(object sender, MouseEventExtArgs e)
        {
            if (e.Button == MouseButtons.Left && isEnabled)
            {
                Debug.WriteLine("Left");
                Click = true;
            }
            else if (e.Button == MouseButtons.Right)
            {
                // MessageBox.Show("Right");
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            var random = new Random();
            int min = Convert.ToInt32(minCps.Text); 
            int max = Convert.ToInt32(maxCps.Text);
            var delay = random.NextInt64((1000 / min) - (1000 / max) + 1) + (1000 / max);
            intervals = Convert.ToInt32(delay);
            MessageBox.Show("CPS: " + intervals);
        }
    }
}