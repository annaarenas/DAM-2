using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace Ejemplo_ComboBox_Checkbox
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();

            List<Capitales> ListaCapitales = new List<Capitales>();

            ListaCapitales.Add(new Capitales() { NombreCapital = "Madrid"});
            ListaCapitales.Add(new Capitales() { NombreCapital = "Paris" });
            ListaCapitales.Add(new Capitales() { NombreCapital = "Berlin" });
            ListaCapitales.Add(new Capitales() { NombreCapital = "Londres" });

            Capitales.ItemsSource = ListaCapitales;
        }

        private void TodasC_Checked(object sender, RoutedEventArgs e)
        {
            Madrid.IsChecked = true;
            Paris.IsChecked = true;
            Berlin.IsChecked = true;
            Londres.IsChecked = true;
        }

        private void TodasC_Unchecked(object sender, RoutedEventArgs e)
        {
            Madrid.IsChecked = false;
            Paris.IsChecked = false;
            Berlin.IsChecked = false;
            Londres.IsChecked = false;
        }

        private void Individual_Checked(object sender, RoutedEventArgs e)
        {
            if(Madrid.IsChecked==true && Paris.IsChecked == true && Berlin.IsChecked == true && Londres.IsChecked == true)
            {
                TodasC.IsChecked = true;
            } else
            {
                TodasC.IsChecked = null;
            }
        }

        private void Individual_Unchecked(object sender, RoutedEventArgs e)
        {
            if (Madrid.IsChecked == false && Paris.IsChecked == false && Berlin.IsChecked == false && Londres.IsChecked == false)
            {
                TodasC.IsChecked = false;
            }
            else
            {
                TodasC.IsChecked = null;
            }
        }
    }

    public class Capitales
    {
        public string NombreCapital {  get; set; }
    }
}