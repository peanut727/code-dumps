using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GradingSystem.Functions
{
    internal class student
    {
        public ArrayList surnames = new ArrayList();
        string stud;

        public void addStudent(string name)
        {
            stud = name;
            surnames.Add(stud);
        }
        public string GetStudent(string targetName)
        {
            foreach (var name in surnames)
            {
                if (name.ToString().Equals(targetName, StringComparison.OrdinalIgnoreCase))
                {
                    return name.ToString(); 
                }
            }
            return null; 
        }
    }
}

