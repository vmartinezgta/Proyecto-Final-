using System.ComponentModel.DataAnnotations;
namespace web_api_1.Models{
    public class Puestos{
        [Key]
        public int id_puesto{get;set;}
        public string puesto {get;set;}
    }
}