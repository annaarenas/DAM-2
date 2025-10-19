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

namespace Ejemplo_ListBox
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();

            List<Poblaciones> listaPob = new List<Poblaciones>();
            listaPob.Add(new Poblaciones() { Poblacion1 = "Madrid", Poblacion2 = "Barcelona", Temp1 = 15, Temp2 = 20});
            listaPob.Add(new Poblaciones() { Poblacion1 = "Valencia", Poblacion2 = "Alicante", Temp1 = 19, Temp2 = 22 });
            listaPob.Add(new Poblaciones() { Poblacion1 = "Málaga", Poblacion2 = "Bilbao", Temp1 = 20, Temp2 = 17 });
            listaPob.Add(new Poblaciones() { Poblacion1 = "Sevilla", Poblacion2 = "Coruña", Temp1 = 22, Temp2 = 16 });

            // Vinculamos los datos de la clase con el ListBox
            listaPoblaciones.ItemsSource = listaPob;

        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            if(listaPoblaciones.SelectedItem != null)
            {
                MessageBox.Show((listaPoblaciones.SelectedItem as Poblaciones).Poblacion1 + " " + (listaPoblaciones.SelectedItem as Poblaciones).Temp1 + " C " + (listaPoblaciones.SelectedItem as Poblaciones).Poblacion2 + " " + (listaPoblaciones.SelectedItem as Poblaciones).Temp2 + " C");
            }
        }
    }

    public class Poblaciones
    {

        public string Poblacion1 { get; set; }
        public int Temp1 { get; set; }

        public string Poblacion2 { get; set; }
        public int Temp2 { get; set; }


    }
}