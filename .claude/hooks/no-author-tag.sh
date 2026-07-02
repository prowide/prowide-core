#!/bin/sh
# PreToolUse hook: reject @author javadoc tags in Java edits.
set -eu

input=$(cat)
tool=$(printf '%s' "$input" | jq -r '.tool_name // empty')
path=$(printf '%s' "$input" | jq -r '.tool_input.file_path // empty')

case "$path" in
  *.java) ;;
  *) exit 0 ;;
esac

case "$tool" in
  Edit)         content=$(printf '%s' "$input" | jq -r '.tool_input.new_string // empty') ;;
  Write)        content=$(printf '%s' "$input" | jq -r '.tool_input.content // empty') ;;
  NotebookEdit) content=$(printf '%s' "$input" | jq -r '.tool_input.new_source // empty') ;;
  *) exit 0 ;;
esac

if printf '%s' "$content" | grep -Eq '(^|[^A-Za-z0-9_])@author([^A-Za-z0-9_]|$)'; then
  cat >&2 <<MSG
Refusing edit: $path introduces an @author javadoc tag.
Project convention (CLAUDE.md): do not use @author. Use @since for new public APIs.
MSG
  exit 2
fi

exit 0
