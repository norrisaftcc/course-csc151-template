## Contribution checklist

Before submitting this pull request, confirm each item:

### Content standards

- [ ] All Java checks pass — run `bash scripts/verify.sh all` from the repository root.
- [ ] Every new example has a `.expected` file recording its output (and a `.stdin` file if it reads input).
- [ ] All new text follows STE rules: active voice, one topic per sentence, consistent terms.
- [ ] Every new term is defined at first use.
- [ ] All Markdown renders correctly — verify headers, code blocks, and Mermaid diagrams in GitHub preview.

### Course alignment

- [ ] Each new lesson or assignment maps to at least one CLO in `docs/clo-mlo-map.md`.
- [ ] New module directories use the course map numbering (`01-environment`, `02-variables-expressions`, etc.).
- [ ] Cross-references in `README.md`, `docs/course-map.md`, and `docs/instructor-guide.md` are updated.

### Coach/player model

- [ ] Any new lesson includes an execute-gate handshake section with all four parts (goal, constraints, prediction, success check).
- [ ] Any new lesson includes a transfer task with a changed condition.
- [ ] Any new lesson includes a mastery record table.

### Metadata

- [ ] If this PR adds a new module, a populated `assignment-metadata.yaml` is included.
- [ ] `CHANGELOG.md` is updated with a summary of changes under `[Unreleased]`.

---

*See [CONTRIBUTING.md](../CONTRIBUTING.md) for full contribution guidelines.*
