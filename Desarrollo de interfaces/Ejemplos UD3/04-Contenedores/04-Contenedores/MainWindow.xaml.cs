using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace _04_Contenedores
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void Border_click(object sender, RoutedEventArgs e)
        {
            WBorder Win = new WBorder();
            Win.Owner = this;
            Win.Show();
        }

        private void Stack_click(object sender, RoutedEventArgs e)
        {
            WStack Win = new WStack();
            Win.Owner = this;
            Win.Show();
        }

        private void Canvas_click(object sender, RoutedEventArgs e)
        {
            WCanvas Win = new WCanvas();
            Win.Owner = this;
            Win.Show();
        }

        private void Grid_click(object sender, RoutedEventArgs e)
        {
            WGrid Win = new WGrid();
            Win.Owner = this;
            Win.Show();
        }

        private void Variable_Click(object sender, RoutedEventArgs e)
        {
            WVariable Win = new WVariable();
            Win.Owner = this;
            Win.Show();
        }
    }
}
