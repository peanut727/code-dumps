﻿using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GradingSystem.Functions
{
    internal class prefinals
    {
        public ArrayList pref = new ArrayList();
        public double grade;
        public void addGrade(string x)
        {
            double cons = Convert.ToDouble(x);
            grade = Math.Round(cons * 0.2);
            pref.Add(grade);
        }

        public double getGrade()
        {
            return grade;
        }
    }
}
