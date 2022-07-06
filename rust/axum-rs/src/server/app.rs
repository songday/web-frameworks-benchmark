use std::net::SocketAddr;

use crate::server::router;

pub async fn start_app() {
    let r = router::gen_router();
    let addr = SocketAddr::from(([127, 0, 0, 1], 3000));
    axum::Server::bind(&addr)
        .serve(r.into_make_service())
        .await
        .unwrap();
}