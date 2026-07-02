#!/bin/sh
# PreToolUse hook: block writes to generated source folders.
set -eu

path=$(jq -r '.tool_input.file_path // empty')
[ -z "$path" ] && exit 0

case "$path" in
  */src/generated/*|*/src/generated)
    cat >&2 <<MSG
Refusing to modify $path.
This file is under src/generated and is copied from external codegen projects.
Edit the upstream codegen source instead, or regenerate locally.
MSG
    exit 2
    ;;
esac

exit 0
