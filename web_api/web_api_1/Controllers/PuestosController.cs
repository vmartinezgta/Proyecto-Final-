using Microsoft.AspNetCore.Mvc;
using System.Linq;
using web_api_1.Models;
namespace web_api_1.Controllers{
[Route("api/[controller]")]
    public class PuestosController : Controller{
        private Conexion dbConexion;
        public PuestosController(){
            dbConexion = Conectar.Create();
        }
         [HttpGet]
        public ActionResult Get(){
            return Ok(dbConexion.Puestos.ToArray());
        }
        [HttpGet("{id}")]
        public ActionResult Get(int id){
            var puestos = dbConexion.Puestos.SingleOrDefault(a =>a.id_puesto ==id);
            if (puestos !=null){
                return Ok(puestos);
                }else{
                    return NotFound();

            }
        }
       [HttpPost]
        public ActionResult Post([FromBody] Puestos puestos){
            if (ModelState.IsValid){
                dbConexion.Puestos.Add(puestos);
                dbConexion.SaveChanges();
                return Ok(puestos);
            }else{
                return NotFound();

            }
        }
       [HttpPut]
        public ActionResult Put([FromBody] Puestos puestos){
            var v_puestos = dbConexion.Puestos.SingleOrDefault(a => a.id_puesto == puestos.id_puesto);
            if(v_puestos !=null && ModelState.IsValid){
                dbConexion.Entry(v_puestos).CurrentValues.SetValues(puestos);
                dbConexion.SaveChanges();
                return Ok();
            }else{
                return NotFound();
            }
        }
        [HttpDelete("{id}")]
        public ActionResult Delete(int id){
            var puestos = dbConexion.Puestos.SingleOrDefault(a => a.id_puesto == id);
            if (puestos !=null){
                dbConexion.Puestos.Remove(puestos);
                dbConexion.SaveChanges();
                return Ok();
            }else{
                return NotFound();
            }
        }
    }
}