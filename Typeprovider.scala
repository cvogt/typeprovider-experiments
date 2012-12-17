import scala.slick.driver.H2Driver.simple._
import scala.slick.driver.H2Driver
import scala.slick.jdbc
import scala.slick.jdbc.reflect.Table
import scala.slick.jdbc.codegen
import scala.slick.jdbc.reflect
import scala.slick.jdbc.JdbcBackend

object Typeprovider extends App{
  def genCode( table : String, connectionString: String ) = {
    Database.forURL(connectionString, driver = "org.h2.Driver") withSession { implicit session:Session =>
      // setup generator
      val tableGen = (new codegen.Schema("H2", new scala.slick.jdbc.reflect.Schema(List(table)), "foo.schema")).tables(0)

      // gen code
      import tableGen._
      s"case class ${entityName}( ${columns.map(c=>c.name+": "+c.scalaType).mkString(", ")} )"
    }
  }

  // create demo schema
  Database.forURL("jdbc:h2:mem:test1;DB_CLOSE_DELAY=-1", driver = "org.h2.Driver") withSession { implicit session:Session =>
    import slick.jdbc.StaticQuery.interpolation
    sqlu"create table COFFEE(COF_NAME varchar(255) NOT NULL, SUP_ID INTEGER NOT NULL, PRICE DOUBLE NOT NULL)".execute
  }

  println( genCode( "COFFEE", "jdbc:h2:mem:test1;DB_CLOSE_DELAY=-1" ) )  
}
