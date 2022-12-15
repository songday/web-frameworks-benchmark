pub(crate) mod db;
pub(crate) mod dto;
pub(crate) mod facade;
pub(crate) mod model;
pub mod server;
pub(crate) mod service;

use std::convert::From;
use std::time::SystemTimeError;

type Result<D> = core::result::Result<D, Error>;

#[derive(Debug)]
struct Error {
    detail: String,
}

impl From<SystemTimeError> for Error {
    fn from(e: SystemTimeError) -> Self {
        Error {
            detail: format!("{:?}", e),
        }
    }
}

impl From<sqlx::Error> for Error {
    fn from(e: sqlx::Error) -> Self {
        Error {
            detail: format!("{:?}", e),
        }
    }
}
