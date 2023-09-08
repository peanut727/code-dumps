namespace POS
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            barcode = new TextBox();
            prodname = new TextBox();
            prodprice = new TextBox();
            button1 = new Button();
            searchNum = new TextBox();
            button2 = new Button();
            label1 = new Label();
            label2 = new Label();
            label3 = new Label();
            label4 = new Label();
            itemName = new Label();
            panel1 = new Panel();
            itemPrice = new Label();
            panel2 = new Panel();
            label5 = new Label();
            totPrice = new Label();
            label6 = new Label();
            panel1.SuspendLayout();
            panel2.SuspendLayout();
            SuspendLayout();
            // 
            // barcode
            // 
            barcode.Location = new Point(131, 59);
            barcode.Name = "barcode";
            barcode.Size = new Size(100, 23);
            barcode.TabIndex = 0;
            // 
            // prodname
            // 
            prodname.Location = new Point(131, 88);
            prodname.Name = "prodname";
            prodname.Size = new Size(100, 23);
            prodname.TabIndex = 1;
            // 
            // prodprice
            // 
            prodprice.Location = new Point(131, 117);
            prodprice.Name = "prodprice";
            prodprice.Size = new Size(100, 23);
            prodprice.TabIndex = 2;
            // 
            // button1
            // 
            button1.Location = new Point(131, 160);
            button1.Name = "button1";
            button1.Size = new Size(100, 23);
            button1.TabIndex = 3;
            button1.Text = "Add product";
            button1.UseVisualStyleBackColor = true;
            button1.Click += button1_Click;
            // 
            // searchNum
            // 
            searchNum.Location = new Point(131, 292);
            searchNum.Name = "searchNum";
            searchNum.Size = new Size(100, 23);
            searchNum.TabIndex = 4;
            // 
            // button2
            // 
            button2.Location = new Point(131, 316);
            button2.Name = "button2";
            button2.Size = new Size(100, 28);
            button2.TabIndex = 5;
            button2.Text = "ADD";
            button2.UseVisualStyleBackColor = true;
            button2.Click += button2_Click;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(55, 62);
            label1.Name = "label1";
            label1.Size = new Size(66, 15);
            label1.TabIndex = 6;
            label1.Text = "Product ID:";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(36, 91);
            label2.Name = "label2";
            label2.Size = new Size(85, 15);
            label2.TabIndex = 7;
            label2.Text = "Product name:";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(87, 120);
            label3.Name = "label3";
            label3.Size = new Size(36, 15);
            label3.TabIndex = 8;
            label3.Text = "Price:";
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Location = new Point(59, 295);
            label4.Name = "label4";
            label4.Size = new Size(66, 15);
            label4.TabIndex = 9;
            label4.Text = "Product ID:";
            // 
            // itemName
            // 
            itemName.AutoSize = true;
            itemName.Font = new Font("Segoe UI", 18F, FontStyle.Bold, GraphicsUnit.Point);
            itemName.Location = new Point(60, 20);
            itemName.Name = "itemName";
            itemName.Size = new Size(0, 32);
            itemName.TabIndex = 10;
            // 
            // panel1
            // 
            panel1.BackColor = SystemColors.AppWorkspace;
            panel1.Controls.Add(itemPrice);
            panel1.Controls.Add(itemName);
            panel1.Location = new Point(291, 28);
            panel1.Name = "panel1";
            panel1.Size = new Size(618, 492);
            panel1.TabIndex = 11;
            // 
            // itemPrice
            // 
            itemPrice.AutoSize = true;
            itemPrice.Font = new Font("Segoe UI", 18F, FontStyle.Bold, GraphicsUnit.Point);
            itemPrice.Location = new Point(489, 17);
            itemPrice.Name = "itemPrice";
            itemPrice.Size = new Size(0, 32);
            itemPrice.TabIndex = 11;
            // 
            // panel2
            // 
            panel2.BackColor = SystemColors.ControlDarkDark;
            panel2.Controls.Add(label5);
            panel2.Controls.Add(totPrice);
            panel2.Location = new Point(291, 404);
            panel2.Name = "panel2";
            panel2.Size = new Size(618, 116);
            panel2.TabIndex = 12;
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Font = new Font("Segoe UI", 36F, FontStyle.Bold, GraphicsUnit.Point);
            label5.Location = new Point(18, 22);
            label5.Name = "label5";
            label5.Size = new Size(290, 65);
            label5.TabIndex = 13;
            label5.Text = "Total Price: ";
            // 
            // totPrice
            // 
            totPrice.AutoSize = true;
            totPrice.Font = new Font("Segoe UI", 24F, FontStyle.Bold, GraphicsUnit.Point);
            totPrice.Location = new Point(348, 38);
            totPrice.Name = "totPrice";
            totPrice.Size = new Size(173, 45);
            totPrice.TabIndex = 12;
            totPrice.Text = "total price";
            // 
            // label6
            // 
            label6.AutoSize = true;
            label6.Location = new Point(131, 186);
            label6.Name = "label6";
            label6.Size = new Size(0, 15);
            label6.TabIndex = 13;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(941, 532);
            Controls.Add(label6);
            Controls.Add(panel2);
            Controls.Add(label4);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(label1);
            Controls.Add(button2);
            Controls.Add(searchNum);
            Controls.Add(button1);
            Controls.Add(prodprice);
            Controls.Add(prodname);
            Controls.Add(barcode);
            Controls.Add(panel1);
            Name = "Form1";
            Text = "Form1";
            panel1.ResumeLayout(false);
            panel1.PerformLayout();
            panel2.ResumeLayout(false);
            panel2.PerformLayout();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private TextBox barcode;
        private TextBox prodname;
        private TextBox prodprice;
        private Button button1;
        private TextBox searchNum;
        private Button button2;
        private Label label1;
        private Label label2;
        private Label label3;
        private Label label4;
        private Label itemName;
        private Panel panel1;
        private Label itemPrice;
        private Panel panel2;
        private Label totPrice;
        private Label label5;
        private Label label6;
    }
}