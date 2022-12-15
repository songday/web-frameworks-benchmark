use std::net::SocketAddr;

use crate::db::init;
use crate::server::router;

pub async fn start_app() {
    if let Err(e) = init().await {
        panic!("{:?}", e);
    }
    let r = router::gen_router();
    let addr = SocketAddr::from(([127, 0, 0, 1], 8080));
    axum::Server::bind(&addr)
        .serve(r.into_make_service())
        .await
        .unwrap();
}
