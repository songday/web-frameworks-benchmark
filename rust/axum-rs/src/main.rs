use tokio::runtime::Builder;

use axum_rs::server::app;

fn main() {
    let runtime = Builder::new_multi_thread()
    .worker_threads(4)
    .thread_name("web-framework-testing")
    .thread_stack_size(3 * 1024 * 1024)
    .enable_io()
    .build()
    .unwrap();
    runtime.block_on(app::start_app());
}
