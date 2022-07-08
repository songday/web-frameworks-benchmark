use crate::server::router;

pub async fn start_app() {
    let routes = router::gen_filters();
    warp::serve(routes).run(([127, 0, 0, 1], 3030)).await;
}
