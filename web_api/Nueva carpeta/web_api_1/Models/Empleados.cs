using System.ComponentModel.DataAnnotations;
namespace web_api_1.Models{
    public class Empleados{
        [Key]
        public int id_empleados{get;set;}
        public string codigo {get;set;}
        public string nombres {get;set;}
        public string apellidos {get;set;}
        public string direccion {get;set;}
        public string telefono {get;set;}
        public string fecha_nacimiento {get;set;}
        public string id_puesto {get;set;}
    }
}