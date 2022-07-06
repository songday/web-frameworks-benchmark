pub(crate) mod book;

use std::convert::From;

use serde::{Deserialize, Serialize};

use crate::Result;

#[derive(Deserialize, Serialize)]
pub(crate) struct Response<D> {
    pub(crate) status: u16,
    pub(crate) data: Option<D>,
    pub(crate) error: Option<String>,
}

impl<D> From<Result<D>> for Response<D> {
    fn from(r: Result<D>) -> Self {
        match r {
            Ok(d) => {
                Response {
                    status: 200,
                    data: Some(d),
                    error: None,
                }
            },
            Err(e) => {
                Response {
                    status: 200,
                    data: None,
                    error: Some(e.detail),
                }
            }
        }
    }
}