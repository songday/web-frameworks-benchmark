use once_cell::sync::OnceCell;
// use sqlx::postgres::PgPoolOptions;
use sqlx::mysql::MySqlPoolOptions;
use sqlx::MySql;

use super::Result;

pub(crate) static DATASOURCE: OnceCell<sqlx::Pool<MySql>> = OnceCell::new();

pub(crate) async fn init() -> Result<()> {
    let pool = MySqlPoolOptions::new().max_connections(5)
        .connect("mysql://root:root-password@localhost:3306/benchmark").await?;
    if let Err(e) = DATASOURCE.set(pool) {
        panic!("{:?}", e);
    }
    Ok(())
}