using Microsoft.EntityFrameworkCore;
namespace web_api_1.Models{
class Conexion : DbContext{
    public Conexion(DbContextOptions<Conexion> options) : base(options){}
    public DbSet<Clientes> Clientes {get;set;}
    public DbSet<Empleados> Empleados {get;set;}
    //aca se agregan los dbset de cada entidad o se de las entdades que representan a las tablas

}
class Conectar{
    private const string cadenaConexion="server=localhost;port=3306;database=db_empresa;userid=usr_empresa;pwd=Empres@123";
    public static Conexion Create(){
        var constructor = new DbContextOptionsBuilder<Conexion>();
        constructor.UseMySQL(cadenaConexion);
        var cn = new Conexion(constructor.Options);
        return cn;

    }
}
}