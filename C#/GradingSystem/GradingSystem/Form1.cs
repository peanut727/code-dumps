using GradingSystem.Functions;

namespace GradingSystem
{
    public partial class Form1 : Form
    {
        prelim _1st = new prelim();
        midterm _2nd = new midterm();
        prefinals _3rd = new prefinals();
        finals _4th = new finals();
        student stud = new student();
        formula form = new formula();

        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            // Adds Grades based on user input
            stud.addStudent(surName.Text);
            _1st.addGrade(grade1.Text);
            _2nd.addGrade(grade2.Text);
            _3rd.addGrade(grade3.Text);
            _4th.addGrade(grade4.Text);

            MessageBox.Show("Added student: " + surName.Text);
        }

        private void button2_Click(object sender, EventArgs e)
        {
            try
            {
                string search = searchName.Text;
                int index = -1; // Initialize to -1, indicating not found

                // Use a foreach loop to search for the surname
                for (int i = 0; i < stud.surnames.Count; i++)
                {
                    if (string.Equals(stud.surnames[i].ToString(), search, StringComparison.OrdinalIgnoreCase))
                    {
                        index = i;
                        break; 
                    }
                }

                if (index >= 0)
                {
                    string studentname = stud.surnames[index].ToString();
                    string prelim = _1st.prel[index].ToString();
                    string midterms = _2nd.midt[index].ToString();
                    string prefinals = _3rd.pref[index].ToString();
                    string finals = _4th.fin[index].ToString();

                    

                    showName.Text = studentname;
                    showGrade1.Text = prelim;
                    showGrade2.Text = midterms;
                    showGrade3.Text = prefinals;
                    showGrade4.Text = finals;
                    finalGrade.Text = Convert.ToString(form.addGrade(prelim, midterms, prefinals, finals));
                }
                else
                {
                    
                    showName.Text =   "";
                    showGrade1.Text = "";
                    showGrade2.Text = "";
                    showGrade3.Text = "";
                    showGrade4.Text = "";
                    MessageBox.Show("Student not found.");
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("An error occurred: " + ex.Message);
            }
        }
    }
}
