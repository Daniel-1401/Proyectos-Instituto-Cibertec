using Microsoft.Data.SqlClient;

namespace VerduritasFit.Data
{
    public class Conexion
    {
        SqlConnection cn = new SqlConnection(@"server =L3NID4; database=VerduritasFit; Trusted_Connection = True;" +
        " MultipleActiveResultSets=True;TrustServerCertificate=False; Encrypt=False");
        public SqlConnection getcn
        {
            get { return cn; }
        }
    }
}
