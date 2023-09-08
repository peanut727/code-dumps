using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections;

namespace POS.Functions
{
    internal class goods
    { 
       
        public List<int> productNum = new List<int>();
        public List<string> productName = new List<string>();
        public List<Decimal> productPrice = new List<Decimal>();

        public int numm;
        public string namee;
        public decimal pricee;


        public void addProd(int num, string name, decimal price)
        {

            productNum.Add(num);
            productName.Add(name);
            productPrice.Add(price);

        }


        public void getProd(int search)
        {

            int index = -1;

            for (int i = 0; i < productNum.Count; i++)
            {
                if (productNum[i] == search)
                {
                    index = i;
                    break;
                }
            } 

            if (index >= 0)
            {

                numm = productNum[index];
                namee = productName[index];
                pricee = productPrice[index];

            }

        }

        public string getName()
        {

            return namee;

        }

        public decimal getPrice()
        {
            return pricee;
        }
     
    }
}
