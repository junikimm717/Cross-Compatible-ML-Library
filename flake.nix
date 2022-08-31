{
  description = "Cross Compatible ML Library";
  inputs = {
    nixpkgs.url = "github:nixos/nixpkgs/nixpkgs-unstable";
    flake-utils.url = "github:numtide/flake-utils";
  };

  outputs = { self, nixpkgs, flake-utils }:
    with flake-utils.lib;
    eachDefaultSystem (system:
      let pkgs = import nixpkgs { inherit system; };
            version = "0.1.0";
      in {
        packages = flattenTree {
          python = pkgs.python3.pkgs.buildPythonPackage rec {
            pname = "cross-compatible-ml-library-python";
            inherit version;
            src = ./Python;
            format = "pyproject";
            propagatedBuildInputs = with pkgs.python3.pkgs; [
              numpy
            ];
            buildInputs = with pkgs.python3.pkgs; [poetry];
            doCheck = false;
          };
        };
        formatter = nixpkgs.legacyPackages."${system}".nixfmt; });
}
