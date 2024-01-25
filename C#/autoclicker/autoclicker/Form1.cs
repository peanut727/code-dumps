using Gma.System.MouseKeyHook;
using System.Diagnostics;
using System.Runtime.CompilerServices;
using System.Runtime.InteropServices;
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
        public int intervals = 1000 / 10;
        public bool Click = false;
        private IKeyboardMouseEvents events;

        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            CheckForIllegalCrossThreadCalls = false;
            Thread thread = new Thread(AutoClick);
            thread.Start();
            //backgroundWorker1.RunWorkerAsync();
            Subscribe();

        }

        public void Subscribe()
        {
            events = Hook.GlobalEvents();

            events.MouseDownExt += GlobalHookMouseDown;
            events.MouseUpExt += GlobalHookMouseUp;
            events.MouseClick += GHookClickEnable;
        }
        private void GHookClickEnable (object sender, MouseEventArgs e)
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
        private void AutoClick()
        {
            while (true)
            {
                if (Click)
                {
                    mouse_event(dwFlags: LEFTUP, dx: 0, dy: 0, cButtons: 0, dwExtraInfo: 0);
                    Thread.Sleep(1);
                    mouse_event(dwFlags: LEFTDOWN, dx: 0, dy: 0, cButtons: 0, dwExtraInfo: 0);
                    Thread.Sleep(intervals);
                }
                Thread.Sleep(1);
            }

        }
        private bool isEnabled = false;
        private void backgroundWorker1_DoWork(object sender, System.ComponentModel.DoWorkEventArgs e)
        {
            while (true)
            {
                if (isEnabled)
                {
                    Thread thread = new Thread(AutoClick);
                    thread.Start();
                }
            }
        }

        private void GlobalHookMouseUp (object sender, MouseEventExtArgs e)
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

        private void GlobalHookMouseDown (object sender, MouseEventExtArgs e)
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

    }
}