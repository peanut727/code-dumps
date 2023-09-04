using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GradingSystem.Functions
{
    internal class formula
    {
        prelim pl = new prelim();
        midterm mt = new midterm();
        prefinals pf = new prefinals();
        finals f = new finals();
        student stud = new student();

        public double addGrade(string x, string y, string z, string s)
        {
            double prelims = Convert.ToDouble(x);
            double midterms = Convert.ToDouble(y);
            double prefinals = Convert.ToDouble(z);
            double finals = Convert.ToDouble(s);
            double solve = Math.Round(prelims + midterms + prefinals + finals);

            return solve;




        }


       
    }
}

