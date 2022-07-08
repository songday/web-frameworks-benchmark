pub(crate) mod dto;
pub(crate) mod facade;
pub mod server;
pub(crate) mod service;

use std::convert::From;
use std::time::SystemTimeError;

type Result<D> = core::result::Result<D, Error>;

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
