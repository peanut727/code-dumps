using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Sizes
{
    internal class functions
    {

        private double num1;
        private double num2;
        private string oper;
        private double solve;
       






        public void setOP(double x, double y, string op)
        {
            num1 = x; 
            num2 = y;
            oper = op;

        }

        public double calcOP()
        {
            switch (oper)
            {
                case "+":
                    solve = num1 + num2;
                    break;
                case "-":
                    solve = num1 - num2;
                    break;
                case "*":
                    solve = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0)
                    {
                        solve = num1 / num2;
                    }
                    else
                    {
                        throw new DivideByZeroException("Error: Division by zero");
                    }
                    break;
                default:
                    throw new ArgumentException("Error: Invalid operator");
            }

            return solve;
        }

        public void getSize()
        {
            double size = solve;

            if (size <= 11)
            {
                MessageBox.Show("Small - " + solve);
            }
            else if (size <= 16)
            {
                MessageBox.Show("Medium - " + solve);
            }
            else if (size <= 24)
            {
                MessageBox.Show("Large - " + solve);
            }
            else if (size >= 32) 
            {
                MessageBox.Show("Xtra-Large - " + solve);
            }
        }
    }
}
