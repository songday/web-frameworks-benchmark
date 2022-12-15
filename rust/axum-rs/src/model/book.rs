use time::OffsetDateTime;

#[derive(sqlx::FromRow)]
pub(crate) struct BookModel {
    pub(crate) id: String,
    pub(crate) title: String,
    pub(crate) preview: String,
    pub(crate) price: u16,
    pub(crate) created_at: OffsetDateTime,
}
